package projet.commun;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import projet.data.Benevoles;
import projet.data.Categorie;
import projet.data.Compte;
import projet.data.Memo;
import projet.data.Participants;
import projet.data.Personne;
import projet.data.Poste;
import projet.data.Service;


@Mapper
public interface IMapper {  
	
	Compte update( @MappingTarget Compte target, Compte source  );
	
	Categorie update( @MappingTarget Categorie target, Categorie source );

	@Mapping( target="categorie", expression="java( source.getCategorie() )" )
	Personne update( @MappingTarget Personne target, Personne source );

	@Mapping( target="categorie", expression="java( source.getCategorie() )" )
	Memo update( @MappingTarget Memo target, Memo source );
	
	Participants update( @MappingTarget Participants target, Participants source);
	
	Poste update( @MappingTarget Poste target, Poste source);

	Service update( @MappingTarget Service target, Service source );
	
	Benevoles update( @MappingTarget Benevoles target, Benevoles source);

}
