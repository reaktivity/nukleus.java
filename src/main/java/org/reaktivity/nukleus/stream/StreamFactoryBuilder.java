/**
 * Copyright 2016-2017 The Reaktivity Project
 *
 * The Reaktivity Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.reaktivity.nukleus.stream;

import java.util.function.Function;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;

import org.agrona.MutableDirectBuffer;
import org.reaktivity.nukleus.buffer.MemoryManager;
import org.reaktivity.nukleus.route.RouteManager;

public interface StreamFactoryBuilder
{
    StreamFactoryBuilder setRouteManager(
        RouteManager router);

    StreamFactoryBuilder setStreamIdSupplier(
        LongSupplier supplyStreamId);

    StreamFactoryBuilder setCorrelationIdSupplier(
        LongSupplier supplyCorrelationId);

    StreamFactoryBuilder setWriteBuffer(
        MutableDirectBuffer writeBuffer);

    StreamFactoryBuilder setMemoryManager(
        MemoryManager memoryManager);

    default StreamFactoryBuilder setCounterSupplier(
        Function<String, LongSupplier> supplyCounter)
    {
        return this;
    }

    default StreamFactoryBuilder setAccumulatorSupplier(
        Function<String, LongConsumer> supplyAccumulator)
    {
        return this;
    }

    StreamFactory build();
}
