package ioctest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MovieRecommender {

	@Autowired
	@Qualifier("action")
	private MovieCatalog actionCatalog;

	private MovieCatalog comedyCatalog;

	@Autowired
	@Qualifier("comedy")
	public void setComedyCatalog( MovieCatalog comedyCatalog) {
		this.comedyCatalog = comedyCatalog;
	}
	}
