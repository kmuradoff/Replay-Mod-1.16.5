package com.replaymod.replay.events;

import com.replaymod.gui.utils.Event;

public interface RenderHotbarCallback {
    Event<RenderHotbarCallback> EVENT = Event.create((listeners) ->
            () -> {
                for (RenderHotbarCallback listener : listeners) {
                    Boolean state = listener.shouldRenderHotbar();
                    if (state != null) {
                        return state;
                    }
                }
                return null;
            }
    );

    Boolean shouldRenderHotbar();
}
