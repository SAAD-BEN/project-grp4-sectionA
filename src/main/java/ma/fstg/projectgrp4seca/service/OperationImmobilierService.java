package ma.fstg.projectgrp4seca.service;

import ma.fstg.projectgrp4seca.bean.BienImmobilier;
import ma.fstg.projectgrp4seca.bean.Client;
import ma.fstg.projectgrp4seca.bean.OperationImmobilier;
import ma.fstg.projectgrp4seca.bean.TypeOperation;
import ma.fstg.projectgrp4seca.dao.OperationImmobilierDao;
import ma.fstg.projectgrp4seca.vo.OperationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class OperationImmobilierService {
    @Autowired
    private OperationImmobilierDao operationImobilierDao;
    @Autowired
    private BienImmobilierService bienImmobilierService;
    @Autowired
    private TypeOperationService typeOperationService;
    @Autowired
    private EntityManager entityManager ;


    public OperationImmobilier findByBienImmobilierTitreFoncier(String titreFoncier) {
        return operationImobilierDao.findByBienImmobilierTitreFoncier(titreFoncier);
    }

    public OperationImmobilier findByTypeOperationLibelle(String libelle) {
        return operationImobilierDao.findByTypeOperationLibelle(libelle);
    }

    @Transactional
    public int deleteByBienImmobilierTitreFoncier(String titreFoncier) {
        return operationImobilierDao.deleteByBienImmobilierTitreFoncier(titreFoncier);
    }

    public List<OperationImmobilier> findAll() {
        return operationImobilierDao.findAll();
    }

    public int save(OperationImmobilier operationImmobilier) {
        BienImmobilier b = bienImmobilierService.findByTitreFoncier(operationImmobilier.getBienImmobilier().getTitreFoncier());
        OperationImmobilier op = findByBienImmobilierTitreFoncier(operationImmobilier.getBienImmobilier().getTitreFoncier());
        TypeOperation tpop = typeOperationService.findByLibelle(operationImmobilier.getTypeOperation().getLibelle());
        if (b == null) {
            return -1;
        } else if (op != null) {
            return -2;
        } else if (tpop == null) {
            return -3;
        } else if (!b.getProprietaire().getRef().equals(operationImmobilier.getProprietaire())){
            return -4;
        }else{
            operationImmobilier.setTypeOperation(tpop);
            operationImmobilier.setBienImmobilier(b);
            operationImobilierDao.save(operationImmobilier);
            return 1;
        }
    }

    public List<OperationVo> findByCriteria(OperationVo operationVo){
        String query="SELECT o FROM OperationImmobilier o WHERE 1=1";
            if(operationVo.getMontantMax()!=null && operationVo.getMontantMax()!="")
                query += " AND o.montant <=  "+operationVo.getMontantMax() ;
            if(operationVo.getMontantMin()!=null && operationVo.getMontantMin()!="")
                query += " AND o.montant >=  "+operationVo.getMontantMin() ;

          return entityManager.createQuery(query).getResultList();
    }

}
