package tw.com.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tw.com.entityManager.EntityManagerHelper;
import tw.com.model.vo.Member;
import tw.com.service.MemberService;

/**
 * Session Bean implementation class MemberBean
 */
public class MemberServiceImpl implements MemberService {
	
	/**
	 * 新增用戶
	 * 
	 * @param id
	 *            Id
	 * @param pws
	 *            Password
	 * @param email
	 *            Email
	 * @param phone
	 *            Phone
	 * @throws Exception
	 */
    public void addUser(String id, String pwd, String email, String phone) throws Exception {
    	
    	EntityManager em = EntityManagerHelper.getEntityManager();
    	EntityTransaction tran = em.getTransaction();
    	
    	Member member = new Member();
    	member.setId(id);
    	member.setPwd(pwd);
    	member.setEmail(email);
    	member.setPhone(phone);

		tran.begin();
        em.persist(member);
        tran.commit();
    }
    
    /**
     * 取得所有會員資料
     * 
     * @return
     * @throws Exception
     */
 
	@SuppressWarnings("unchecked")
    public List<Member> getMember() throws Exception {
		
		EntityManager em = EntityManagerHelper.getEntityManager();
		
        List<Member> memberList = null;
        Query query = em.createNamedQuery("Member.findAll");
        memberList = (List<Member>) query.getResultList();
        return memberList;
    }
}
