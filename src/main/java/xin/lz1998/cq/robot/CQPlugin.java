package xin.lz1998.cq.robot;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Component;
import xin.lz1998.cq.event.message.CQDiscussMessageEvent;
import xin.lz1998.cq.event.message.CQGroupMessageEvent;
import xin.lz1998.cq.event.message.CQPrivateMessageEvent;
import xin.lz1998.cq.event.meta.CQHeartBeatEvent;
import xin.lz1998.cq.event.notice.CQFriendAddNoticeEvent;
import xin.lz1998.cq.event.notice.CQGroupAdminNoticeEvent;
import xin.lz1998.cq.event.notice.CQGroupBanNoticeEvent;
import xin.lz1998.cq.event.notice.CQGroupDecreaseNoticeEvent;
import xin.lz1998.cq.event.notice.CQGroupIncreaseNoticeEvent;
import xin.lz1998.cq.event.notice.CQGroupUploadNoticeEvent;
import xin.lz1998.cq.event.request.CQFriendRequestEvent;
import xin.lz1998.cq.event.request.CQGroupRequestEvent;

@Component
public class CQPlugin {
    public static final int MESSAGE_BLOCK = 1;
    public static final int MESSAGE_IGNORE = 0;

    public int onPrivateMessage(CoolQ cq, CQPrivateMessageEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupMessage(CoolQ cq, CQGroupMessageEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onDiscussMessage(CoolQ cq, CQDiscussMessageEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupUploadNotice(CoolQ cq, CQGroupUploadNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupAdminNotice(CoolQ cq, CQGroupAdminNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupDecreaseNotice(CoolQ cq, CQGroupDecreaseNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupIncreaseNotice(CoolQ cq, CQGroupIncreaseNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupBanNotice(CoolQ cq, CQGroupBanNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onFriendAddNotice(CoolQ cq, CQFriendAddNoticeEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onFriendRequest(CoolQ cq, CQFriendRequestEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onGroupRequest(CoolQ cq, CQGroupRequestEvent event) {
        return MESSAGE_IGNORE;
    }

    public int onHeartBeatMeta(CoolQ cq, CQHeartBeatEvent event) {
        return MESSAGE_IGNORE;
    }
}