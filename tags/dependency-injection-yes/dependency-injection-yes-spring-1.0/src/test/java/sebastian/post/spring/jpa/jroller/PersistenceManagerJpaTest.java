package sebastian.post.spring.jpa.jroller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import model.hello.Message;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PersistenceManagerJpaTest {

	@Autowired
	PersistenceManager persistenceManger;
	

	
/*
 * Con questo sistema non riesco a gestire il rollback....
 * Se invece estendo la classe: AbstractJpaTests, allora gestisco il rollback dei test.
 * */
	@Rollback(true)
	@Test
	public void testSave() {
		assertNotNull(persistenceManger);

		Message msg = new Message();
		msg.setText("adsgfvsfg");

		assertNull(msg.getId());
		try {
			persistenceManger.save(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(msg.getId());

		List<Object> findAll = persistenceManger.findAll(Message.class);

		assertNotNull(findAll);
		assertEquals(1, findAll.size());
	}

}
