/*
 * This file is part of Sponge, licensed under the MIT License (MIT).
 *
 * Copyright (c) SpongePowered.org <http://www.spongepowered.org>
 * Copyright (c) contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.spongepowered.api.text;

import org.spongepowered.api.text.action.ClickAction;
import org.spongepowered.api.text.action.HoverAction;
import org.spongepowered.api.text.style.TextFormat;
import org.spongepowered.api.text.style.TextStyle;
import org.spongepowered.api.text.translation.Translatable;
import org.spongepowered.api.text.translation.Translation;

public interface MessageBuilder<T> {

    Message<T> build(); // TODO

    MessageBuilder<T> content(T text);

    interface VisibleMessageBuilder<T> extends MessageBuilder<T> {

        MessageBuilder<T> format(TextFormat format);

        MessageBuilder<T> color(TextStyle style);

        MessageBuilder<T> insertion(String insertion);

        <V> MessageBuilder<T> clickAction(ClickAction<V> clickAction);

        <V> MessageBuilder<T> hoverAction(HoverAction<V> hoverAction);
    }

    interface TextMessageBuilder extends VisibleMessageBuilder<String> {

        TextMessageBuilder add(Iterable<Message<String>> child);

        TextMessageBuilder add(Message<?>... child);

    }

    interface TranslatableMessageBuilder extends VisibleMessageBuilder<Translatable> {

        TranslatableMessageBuilder translation(Translation translation);

        TranslatableMessageBuilder arg(Message<?>... arg);

        TranslatableMessageBuilder arg(Iterable<Message<?>> arg);

    }

    // TODO score api
    interface ScoreMessageBuilder extends MessageBuilder<Object> {

        ScoreMessageBuilder override(Object score, String value);

    }

    interface SelectorMessageBuilder extends VisibleMessageBuilder<Object> {

    }


}
