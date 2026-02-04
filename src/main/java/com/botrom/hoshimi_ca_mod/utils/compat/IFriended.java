package com.botrom.hoshimi_ca_mod.utils.compat;

import java.util.UUID;

public interface IFriended {
	boolean isChanged();

	void setChanged(boolean value);

	boolean isFriendly();

	void setFriendly(boolean value);

	UUID getFriendedBy();

	void setFriendedBy(UUID uuid);
}
