package pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.json.JsonMapper;
import pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.dto.ProductoDTO;
import pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.entity.ProductoEntity;
import pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.repository.ProductoRepository;
import pe.edu.galaxy.training.java.ms.sc.ventas.msventasgestionproductos.service.exception.ServiceException;

@Service
public class ProductoServiceImpl implements ProductoService{
 
	private ProductoRepository productoRepository;
	private JsonMapper jsonMapper;
	
	public ProductoServiceImpl(	ProductoRepository productoRepository,
								JsonMapper jsonMapper
									) {
		super();
		this.productoRepository = productoRepository;
		this.jsonMapper=jsonMapper;
	}

	@Override
	public List<ProductoDTO> findByLike(ProductoDTO t) throws ServiceException {
		try {
			List<ProductoEntity> lstProductoEntity= productoRepository.findAll();
			return lstProductoEntity.stream().map(e -> this.getProductoDTO(e))
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
		
	}

	@Override
	public Optional<ProductoDTO> findById(Long id) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	// Mappers
	private ProductoDTO getProductoDTO(ProductoEntity e) {
		return jsonMapper.convertValue(e, ProductoDTO.class);
	}
	
	private ProductoEntity getProductoEntity(ProductoDTO d) {
		return jsonMapper.convertValue(d, ProductoEntity.class);
	}
	
}
