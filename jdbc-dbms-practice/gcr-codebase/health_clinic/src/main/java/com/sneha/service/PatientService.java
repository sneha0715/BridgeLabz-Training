package com.sneha.service;

import com.sneha.dao.PatientDao;
import com.sneha.model.Patient;

public class PatientService {

    private PatientDao dao = new PatientDao();

    public void registerPatient(Patient p) throws Exception {

        if (dao.existsByPhoneOrEmail(p.getPhone(), p.getEmail())) {
            throw new Exception("Patient already exists with same phone or email.");
        }

        dao.insert(p);
    }
}
