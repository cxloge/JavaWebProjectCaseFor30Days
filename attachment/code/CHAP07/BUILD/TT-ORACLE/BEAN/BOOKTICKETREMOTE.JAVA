package wyf.zrk;

import javax.ejb.*;

//本地接口继承自业务接口
@Remote
public interface BookTicketRemote extends BookTicket
{
}
