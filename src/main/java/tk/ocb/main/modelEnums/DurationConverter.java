package tk.ocb.main.modelEnums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter
public class DurationConverter implements AttributeConverter<Duration, String>{

	@Override
	public String convertToDatabaseColumn(Duration attribute) {
		// TODO Auto-generated method stub
		if(attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public Duration convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		if(dbData == null) {
			return null;
		}
		return Stream.of(Duration.values())
				.filter(c -> c.toString().equals(dbData))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
