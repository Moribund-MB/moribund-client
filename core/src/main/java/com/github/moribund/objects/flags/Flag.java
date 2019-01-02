package com.github.moribund.objects.flags;

import com.github.moribund.objects.attributes.Flaggable;

public interface Flag {
    void processFlag(Flaggable flaggable);
}
