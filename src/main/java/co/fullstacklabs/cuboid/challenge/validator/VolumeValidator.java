package co.fullstacklabs.cuboid.challenge.validator;

import co.fullstacklabs.cuboid.challenge.dto.CuboidDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VolumeValidator implements ConstraintValidator<Volume, CuboidDTO> {

    @Override
    public void initialize(Volume constraintAnnotation) {
    }

    @Override
    public boolean isValid(CuboidDTO cuboidDTO, ConstraintValidatorContext context) {
        if (cuboidDTO.getDepth() == null || cuboidDTO.getWidth() == null || cuboidDTO.getHeight() == null) {
            return false;
        }
        if (!Double.valueOf(cuboidDTO.getDepth() * cuboidDTO.getHeight() * cuboidDTO.getWidth()).equals(cuboidDTO.getVolume())){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "error message");
        }
        return true;
    }
}
