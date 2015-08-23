package sebastian.post.spring.jpa.jroller;

import java.util.List;

import model.BaseModel;

import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly=true)
public interface PersistenceManager {
    
    public <T> List<T> findAll(Class<? extends BaseModel> entityClass);

    public <T> T find(Class<? extends BaseModel> entityClass, Long id);
    
    @Transactional(readOnly=false)
    public void save(BaseModel entity);
    
    @Transactional(readOnly=false)
    public <T> T merge(T entity);

    @Transactional(readOnly=false)
    public void remove(BaseModel entity);
}
