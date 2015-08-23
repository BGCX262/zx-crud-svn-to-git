
package petclinic.tutorial;

import static org.junit.Assert.assertNull;

import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;

import model.hello.Message;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.test.annotation.ExpectedException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.jpa.AbstractJpaTests;

/**
 * <p>
 * This class extends {@link AbstractJpaTests}, one of the valuable test
 * superclasses provided in the <code>org.springframework.test</code> package.
 * This represents best practice for integration tests with Spring for JPA based
 * tests which require <em>shadow class loading</em>. For all other types of
 * integration testing, the <em>Spring TestContext Framework</em> is
 * preferred.
 * </p>
 * <p>
 * AbstractJpaTests and its superclasses provide the following services:
 * <ul>
 * <li>Injects test dependencies, meaning that we don't need to perform
 * application context lookups. See the setClinic() method. Injection uses
 * autowiring by type.</li>
 * <li>Executes each test method in its own transaction, which is automatically
 * rolled back by default. This means that even if tests insert or otherwise
 * change database state, there is no need for a teardown or cleanup script.</li>
 * <li>Provides useful inherited protected fields, such as a
 * {@link SimpleJdbcTemplate} that can be used to verify database state after
 * test operations, or verify the results of queries performed by application
 * code. Alternatively, you can use protected convenience methods such as
 * {@link #countRowsInTable(String)}, {@link #deleteFromTables(String[])},
 * etc. An ApplicationContext is also inherited, and can be used for explicit
 * lookup if necessary.</li>
 * </ul>
 * <p>
 * {@link AbstractJpaTests} and related classes are shipped in
 * <code>spring-test.jar</code>.
 * </p>
 *
 * @author Rod Johnson
 * @author Sam Brannen
 * @see AbstractJpaTests
 */
public abstract class AbstractJpaMessageDaoTests extends AbstractJpaTests {



	protected MessageDao messageDao;





	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

//	public void testApplicationManaged() {
//		EntityManager appManaged = this.entityManagerFactory.createEntityManager();
//		appManaged.joinTransaction();
//	}

	
	
	// @Rollback(false) se voglio che venga fatto commit sul test e salvare i dati nel db.
	@Rollback(true) 
	public void testInsertMessage() {
		Message msg = new Message();
		msg.setText("salvo un messaggio");

		assertNull(msg.getId());
		
		this.messageDao.save(msg);
		assertNotNull(msg.getId());
	}



}
