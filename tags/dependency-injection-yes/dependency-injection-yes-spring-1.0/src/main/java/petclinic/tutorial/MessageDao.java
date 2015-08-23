package petclinic.tutorial;

import org.springframework.transaction.annotation.Transactional;

import model.hello.Message;

@Transactional
public interface MessageDao {

	void save(Message msg);

}
