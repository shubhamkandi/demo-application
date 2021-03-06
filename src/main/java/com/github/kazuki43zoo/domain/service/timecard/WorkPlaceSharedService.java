package com.github.kazuki43zoo.domain.service.timecard;

import com.github.kazuki43zoo.domain.model.timecard.WorkPlace;

public interface WorkPlaceSharedService {

    WorkPlace getMainOffice();

    WorkPlace getWorkPlace(String workPlaceUuid);

    WorkPlace getWorkPlaceDetail(WorkPlace workPlace);

}
