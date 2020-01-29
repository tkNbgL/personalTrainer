package tk.ocb.main.modelEnums;

import java.util.stream.Stream;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class IntensityConverter implements AttributeConverter<Intensity, String>{

	@Override
	public String convertToDatabaseColumn(Intensity attribute) {
		// TODO Auto-generated method stub
		if(attribute == null) {
			return null;
		}
		
		return attribute.toString();
	}

	@Override
	public Intensity convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		if(dbData == null) {
			return null;
		}
		
		return Stream.of(Intensity.values())
					.filter(c -> c.toString().equals(dbData))
					.findFirst()
					.orElseThrow(IllegalArgumentException::new);
	}

}
