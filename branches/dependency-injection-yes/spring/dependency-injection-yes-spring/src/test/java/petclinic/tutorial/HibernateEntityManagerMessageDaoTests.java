package petclinic.tutorial;


public class HibernateEntityManagerMessageDaoTests extends MessageDaoImplTests {

	@Override
	protected String[] getConfigPaths() {
		return new String[] {
			"applicationContext-jpaCommon.xml",
			"applicationContext-hibernateAdapter.xml",
			"applicationContext-entityManager.xml"
		};
	}

}
