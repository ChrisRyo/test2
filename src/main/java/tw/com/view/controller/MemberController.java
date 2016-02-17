package tw.com.view.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tw.com.model.vo.Member;

/**
 * 
 * @author chrisryo
 * 
 * 註 : @Consumes接受類型, @Produces返回類型
 *
 */
@Path("/member")
public class MemberController {
	
	

	/**
	 * 取所有資料
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getAllMember() throws Exception {

		MemberLocal memberBean =(MemberLocal)TestUtils.getEJB("MemberService", MemberLocal.class);
		
		
        List<Member> memberList = memberBean.getMember();
        return memberList;
	}
	
	/**
	 *  寫入資料
	 *  
	 * @param member
	 * @return
	 * @throws Exception 
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Member> getTodos(Member member) throws Exception {
		
		MemberLocal memberBean =(MemberLocal)TestUtils.getEJB("MemberService", MemberLocal.class);
		
		memberBean.addUser(member.getId(), member.getPwd(), member.getEmail(), member.getPhone());
		
		return getAllMember();
    }
	
}