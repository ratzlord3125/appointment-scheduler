package com.oops.ratzlord.appointmentscheduler.service;

import com.oops.ratzlord.appointmentscheduler.entity.WorkingPlan;
import com.oops.ratzlord.appointmentscheduler.model.TimePeroid;

public interface WorkingPlanService {
    void updateWorkingPlan(WorkingPlan workingPlan);

    void addBreakToWorkingPlan(TimePeroid breakToAdd, int planId, String dayOfWeek);

    void deleteBreakFromWorkingPlan(TimePeroid breakToDelete, int planId, String dayOfWeek);

    WorkingPlan getWorkingPlanByProviderId(int providerId);
}
