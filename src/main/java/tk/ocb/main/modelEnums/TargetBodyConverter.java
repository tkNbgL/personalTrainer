package tk.ocb.main.modelEnums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class TargetBodyConverter implements AttributeConverter<TargetBody, String>{

	@Override
	public String convertToDatabaseColumn(TargetBody attribute) {
		// TODO Auto-generated method stub
		if(attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public TargetBody convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		if(dbData == null) {
			return null;
		}
		return Stream.of(TargetBody.values())
				.filter(c -> c.toString().equals(dbData))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
