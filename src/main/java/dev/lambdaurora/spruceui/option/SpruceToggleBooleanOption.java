/*
 * Copyright © 2020 LambdAurora <email@lambdaurora.dev>
 *
 * This file is part of SpruceUI.
 *
 * Licensed under the MIT license. For more information,
 * see the LICENSE file.
 */

package dev.lambdaurora.spruceui.option;

import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.widget.SpruceToggleSwitch;
import dev.lambdaurora.spruceui.widget.SpruceWidget;
import net.minecraft.network.chat.Text;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Represents a boolean option.
 * <p>
 * Works the as {@link SpruceBooleanOption} but uses a toggle switch instead.
 *
 * @author LambdAurora
 * @version 6.1.0
 * @since 2.0.0
 */
public class SpruceToggleBooleanOption extends SpruceBooleanOption {
	private final boolean showMessage;

	public SpruceToggleBooleanOption(String key, Supplier<Boolean> getter, Consumer<Boolean> setter, @Nullable Text tooltip, boolean showMessage) {
		super(key, getter, setter, tooltip, false);
		this.showMessage = showMessage;
	}

	public SpruceToggleBooleanOption(String key, Supplier<Boolean> getter, Consumer<Boolean> setter, @Nullable Text tooltip) {
		this(key, getter, setter, tooltip, true);
	}

	@Override
	public SpruceWidget createWidget(Position position, int width) {
		var button = new SpruceToggleSwitch(position, width, 20, this.getDisplayText(), (btn, newValue) -> {
			this.set();
			btn.setMessage(this.getDisplayText());
			this.getOptionTooltip().ifPresent(btn::setTooltip);
		}, this.get(), this.showMessage);
		this.getOptionTooltip().ifPresent(button::setTooltip);
		return button;
	}

	@Override
	public Text getDisplayText() {
		return this.getPrefix();
	}

	@Override
	public Text getDisplayText(Text value) {
		return this.getPrefix();
	}
}
