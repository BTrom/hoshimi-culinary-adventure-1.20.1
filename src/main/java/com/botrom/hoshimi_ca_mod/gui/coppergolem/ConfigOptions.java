package com.botrom.hoshimi_ca_mod.gui.coppergolem;

import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.control.IntegerFieldControl;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.control.SliderControl;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.control.TextBoxControl;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.control.TickBoxControl;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.Option;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.OptionGroup;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.OptionImpl;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.options.OptionPage;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines all config options and organizes them into pages.
 */
public class ConfigOptions {

    public static List<OptionPage> createPages() {
        List<OptionPage> pages = new ArrayList<>();
        
        pages.add(createGolemPage());
        pages.add(createVisualPage());
        pages.add(createCompatibilityPage());
        // Add more pages here as needed
        
        return pages;
    }

    private static OptionPage createGolemPage() {
        // Golem behavior option
        Option<Boolean> golemPressesButtons = OptionImpl.<Boolean>builder(Boolean.class)
            .name("config.copperagebackport.golem_presses_buttons")
            .tooltip("config.copperagebackport.golem_presses_buttons.tooltip")
            .control(TickBoxControl::new)
            .binding(
                ModConfig::golemPressesButtons,
                ModConfig::setGolemPressesButtons
            )
            .defaultValue(true)
            .build();

        // Button press chance option
        Option<Integer> buttonPressChance = OptionImpl.<Integer>builder(Integer.class)
            .name("config.copperagebackport.button_press_chance")
            .tooltip("config.copperagebackport.button_press_chance.tooltip")
            .control(opt -> new SliderControl(opt, 0, 100, 5, "%"))
            .binding(
                ModConfig::buttonPressChancePercent,
                ModConfig::setButtonPressChancePercent
            )
            .defaultValue(10)
            .available(ModConfig::golemPressesButtons)
            .build();

        // Golem transport stack size option
        Option<Integer> golemTransportStackSize = OptionImpl.<Integer>builder(Integer.class)
            .name("config.copperagebackport.golem_transport_stack_size")
            .tooltip("config.copperagebackport.golem_transport_stack_size.tooltip")
            .control(opt -> new SliderControl(opt, 1, 64, 1, ""))
            .binding(
                ModConfig::golemTransportStackSize,
                ModConfig::setGolemTransportStackSize
            )
            .defaultValue(16)
            .build();

        // Weathering time from option
        Option<Integer> weatheringTickFrom = OptionImpl.<Integer>builder(Integer.class)
            .name("config.copperagebackport.weathering_tick_from")
            .tooltip("config.copperagebackport.weathering_tick_from.tooltip")
            .control(opt -> new IntegerFieldControl(opt, 0, 10000000, IntegerFieldControl.ValueFormatter.realMinutes()))
            .binding(
                ModConfig::weatheringTickFrom,
                ModConfig::setWeatheringTickFrom
            )
            .defaultValue(504000)
            .build();

        // Weathering time to option (must be >= from) - reads from weatheringTickFrom's buffer value
        Option<Integer> weatheringTickTo = OptionImpl.<Integer>builder(Integer.class)
            .name("config.copperagebackport.weathering_tick_to")
            .tooltip("config.copperagebackport.weathering_tick_to.tooltip")
            .control(opt -> new IntegerFieldControl(opt, weatheringTickFrom::getValue, 10000000, IntegerFieldControl.ValueFormatter.realMinutes()))
            .binding(
                ModConfig::weatheringTickTo,
                ModConfig::setWeatheringTickTo
            )
            .defaultValue(552000)
            .build();

        // Create groups
        OptionGroup transportGroup = OptionGroup.builder()
            .name("config.copperagebackport.group.transport")
            .add(golemTransportStackSize)
            .build();

        OptionGroup behaviorGroup = OptionGroup.builder()
            .name("config.copperagebackport.group.behavior")
            .add(golemPressesButtons)
            .add(buttonPressChance)
            .build();

        OptionGroup weatheringGroup = OptionGroup.builder()
            .name("config.copperagebackport.group.weathering")
            .add(weatheringTickFrom)
            .add(weatheringTickTo)
            .build();

        return OptionPage.builder()
            .name("config.copperagebackport.page.golem")
            .add(transportGroup)
            .add(behaviorGroup)
            .add(weatheringGroup)
            .build();
    }

    private static OptionPage createCompatibilityPage() {
        // Lightning Rod oxidation info - always enabled, just informational
        Option<String> lightningRodInfo = OptionImpl.<String>builder(String.class)
            .name("config.copperagebackport.lightning_rod_oxidation")
            .control(TextBoxControl::new)
            .binding(
                () -> "config.copperagebackport.lightning_rod_oxidation.text",
                (v) -> {} // Read-only
            )
            .defaultValue("config.copperagebackport.lightning_rod_oxidation.text")
            .build();

        // Create group
        OptionGroup lightningRodGroup = OptionGroup.builder()
            .name("config.copperagebackport.group.lightning_rod")
            .add(lightningRodInfo)
            .build();

        return OptionPage.builder()
            .name("config.copperagebackport.page.compatibility")
            .add(lightningRodGroup)
            .build();
    }

    private static OptionPage createVisualPage() {
        // End Flash toggle option
        Option<Boolean> endFlashEnabled = OptionImpl.<Boolean>builder(Boolean.class)
            .name("config.copperagebackport.end_flash_enabled")
            .tooltip("config.copperagebackport.end_flash_enabled.tooltip")
            .control(TickBoxControl::new)
            .binding(
                ModConfig::endFlashEnabled,
                ModConfig::setEndFlashEnabled
            )
            .defaultValue(true)
            .build();

        // Create group
        OptionGroup endGroup = OptionGroup.builder()
            .name("config.copperagebackport.group.end")
            .add(endFlashEnabled)
            .build();

        return OptionPage.builder()
            .name("config.copperagebackport.page.visual")
            .add(endGroup)
            .build();
    }
}
