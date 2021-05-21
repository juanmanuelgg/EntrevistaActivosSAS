package co.com.activos.subchapter;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubchapterService {
	@Autowired
	private ISubchapterRepository subchapterRepository;

	@Transactional
	public List<Subchapter> findAll() {
		return (List<Subchapter>) subchapterRepository.findAll();
	}
}