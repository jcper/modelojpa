import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.corppm.technology.pruebas.entidades.Cliente;
import com.corppm.technology.pruebas.entidades.Orden;
import com.corppm.technology.pruebas.entidades.OrdenDetalle;
import com.corppm.technology.pruebas.entidades.Producto;

public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("testunit");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Query query = em.createQuery("SELECT o FROM Cliente o");
		if (query.getResultList().size() == 0) {
			poblarDatos(em);
		}
		Orden orden = new Orden();
		orden.setCliente(em.find(Cliente.class, 10L));
		orden.setFecha(new Date());
		List<OrdenDetalle> detalles = new ArrayList<OrdenDetalle>();
		OrdenDetalle ordenDetalle = new OrdenDetalle();
		ordenDetalle.setOrden(orden);
		ordenDetalle.setProducto(em.find(Producto.class, 100L));
		ordenDetalle.setCantidad(12);
		detalles.add(ordenDetalle);
		ordenDetalle = new OrdenDetalle();
		ordenDetalle.setOrden(orden);
		ordenDetalle.setProducto(em.find(Producto.class, 200L));
		ordenDetalle.setCantidad(99);
		detalles.add(ordenDetalle);
		orden.setDetalles(detalles);
		em.persist(orden);
		em.flush();
		em.remove(orden);
		tx.commit();
	}

	private static void poblarDatos(EntityManager em) {
		Cliente cliente = new Cliente();
		cliente.setId(10L);
		cliente.setDNA("1088888888201345");
		cliente.setNombreCompleto("Nombre Completo 1");
		em.persist(cliente);
		Producto producto = new Producto();
		producto.setId(100L);
		producto.setSKU("SKU001A");
		producto.setNombre("Producto A");
		producto.setPrecio(23.34);
		em.persist(producto);
		producto = new Producto();
		producto.setId(200L);
		producto.setSKU("SKU003B");
		producto.setNombre("Producto B");
		producto.setPrecio(11.09);
		em.persist(producto);
	}

}
