package tk.ocb.main.modelEnums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class DifficultyConverter implements AttributeConverter<Difficulty, String>{

	@Override
	public String convertToDatabaseColumn(Difficulty attribute) {
		// TODO Auto-generated method stub
		if(attribute == null) {
			return null;
		}
		
		return attribute.toString();
	}

	@Override
	public Difficulty convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		if(dbData == null) {
			return null;
		}
		
		return Stream.of(Difficulty.values())
					.filter(c -> c.toString().equals(dbData))
					.findFirst()
					.orElseThrow(IllegalArgumentException::new);
	}

}
