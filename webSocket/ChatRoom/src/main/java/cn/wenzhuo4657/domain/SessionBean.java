package cn.wenzhuo4657.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.socket.WebSocketSession;

/**
 * @className: SessionBean
 * @author: wenzhuo4657
 * @date: 2024/4/9 20:41
 * @Version: 1.0
 * @description:
 */

@AllArgsConstructor
@Data
@NoArgsConstructor
public class SessionBean {
    private WebSocketSession webSocketSession;
    private  Integer clientId;
}