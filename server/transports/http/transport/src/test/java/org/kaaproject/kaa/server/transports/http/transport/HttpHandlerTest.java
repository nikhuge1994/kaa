/*
 * Copyright 2014 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.transports.http.transport;

import java.util.UUID;

import org.junit.Test;
import org.kaaproject.kaa.server.transport.channel.ChannelType;
import org.kaaproject.kaa.server.transport.message.MessageHandler;
import org.kaaproject.kaa.server.transports.http.transport.commands.AbstractHttpSyncCommand;
import org.kaaproject.kaa.server.transports.http.transport.messages.NettyHttpSyncMessage;
import org.mockito.Mockito;

public class HttpHandlerTest {

    @Test
    public void testFlow() throws Exception{
        UUID uuid = UUID.randomUUID();
        MessageHandler messageHandler = Mockito.mock(MessageHandler.class);
        AbstractHttpSyncCommand commandMock = Mockito.mock(AbstractHttpSyncCommand.class);
        Mockito.when(commandMock.getChannelType()).thenReturn(ChannelType.SYNC);
        HttpHandler handler = new HttpHandler(uuid, messageHandler);
        handler.channelRead0(null, commandMock);
        Mockito.verify(messageHandler).process(Mockito.any(NettyHttpSyncMessage.class));
    }
}
