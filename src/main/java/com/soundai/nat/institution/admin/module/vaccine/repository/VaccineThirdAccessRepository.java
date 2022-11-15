package com.soundai.nat.institution.admin.module.vaccine.repository;

import com.soundai.nat.institution.admin.module.common.domain.NatPerson;
import com.soundai.nat.institution.admin.module.common.domain.NatVaccineRegister;
import com.soundai.nat.institution.admin.module.common.domain.VaccinationInfo;
import com.soundai.nat.institution.admin.module.vaccine.domain.AppointmentInfoParam;
import com.soundai.nat.institution.admin.module.vaccine.domain.UserInfoParam;

public interface VaccineThirdAccessRepository {
    NatVaccineRegister appointmentSearch(AppointmentInfoParam appointmentInfoParam);
    NatPerson queryPersonAppoInfo(UserInfoParam userInfoParam);

    VaccinationInfo saveVaccinationInfo(VaccinationInfo vaccinationInfo);
}
