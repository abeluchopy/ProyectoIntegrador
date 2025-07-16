package ProyectoIntegrador.repository;

import ProyectoIntegrador.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {}
