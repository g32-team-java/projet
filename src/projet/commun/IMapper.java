package projet.commun;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import projet.data.Benevoles;

import projet.data.Compte;

import projet.data.Participants;

import projet.data.Poste;



@Mapper
public interface IMapper {  
	
	Compte update( @MappingTarget Compte target, Compte source  );
	

	
	Participants update( @MappingTarget Participants target, Participants source);
	
	Poste update( @MappingTarget Poste target, Poste source);


	
	Benevoles update( @MappingTarget Benevoles target, Benevoles source);

}
