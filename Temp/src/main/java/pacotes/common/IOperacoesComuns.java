package pacotes.common;

import java.io.Serializable;
import java.util.List;

import pacotes.bean.Telefone;
/**
*
* @author Tiago M
*/
public interface IOperacoesComuns<T extends Serializable> {

	T load(Long id);

	List<T> listall();

	void persist(final T entity);

	void delete(final long entityId);
}
