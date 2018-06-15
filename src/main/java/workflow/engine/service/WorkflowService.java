/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import workflow.engine.entity.Request;

/**
 *
 * @author trungchanh
 */
public interface WorkflowService {

    /**
     * When an user perform an action on a system. <br>
     * That system can call this
     * API to complete the action in Workflow Engine. <br>
     * After the action is
     * completed, Workflow Engine will make changes on the request. <br>
     * It will
     * change state of the request if no more action need to be done at current
     * state. <br>
     * Example: if the current state need 2 actions completed before
     * transit the request to next state. <br>
     * When users done 1 of 2 actions,
     * the request still remain at current state. <br>
     * But if both actions are
     * done, the request will be transited to next state.
     *
     * @param requestId (int64): the request which the action belongs to.
     * @param actionId (int64): the action need to be performed.
     * @param userId (int64): the user who perform this action.
     * @return This API will return a JSON object which will have some
     * information of the request: <br>
     * - Basic information like: id, title,
     * current state, created user, updated user, created time, udpated time
     * <br>
     * - Available actions: the actions users can perform right now(e.g:
     * APPROVE, REJECT, CANCEL, …) <br>
     * - Need-to-be-done activities: after
     * users apply/approve/reject a request(perform an action), there will be
     * something need to be done. (e.g: send mail to stakeholders)
     */
    Request doRequestAction(long requestId, long actionId, long userId);

    /**
     * This API will return current information of the request. <br>
     * All information is the same as the API /workflow/requests except
     * activities. <br>
     * The activities property will be always empty because activties are only
     * necessary right after when users have performed an action.
     *
     * @param requestId (long): request id
     * @return This API will return a JSON object which will have some
     * information of the request: <br>
     * - Basic information like: id, title, current state, created user, updated
     * user, created time, udpated time <br>
     * - Available actions: the actions users can perform right now(e.g:
     * APPROVE, REJECT, CANCEL, …)
     */
    Request getRequest(Long requestId);

    /**
     * When an user create a new request in a system. <br>
     * That system can call this API to create a corresponding object in
     * Workflow Engine. <br>
     * This object will hold all information about current state of the request,
     * list of actions can be performed at each state, list of activities need
     * to be done after every time an action get completed. <br>
     *
     * @param processId (long): this param will help Workflow Engine know how to
     * handle the request. The process will let us know: <br>
     * - Current state of this request <br>
     * - Actions users can perform now <br>
     * - Who can perform which action<br>
     * - Activities we have to do right now
     * <br>
     * @param userId (long): the user who create this request.
     * <br>
     * @param title (String): request title
     * <br>
     * @param doApply (boolean): this param is optional.
     * <br> - If true, Workflow Engine will automatically APPLY this request
     * after created.
     * <br> - If false, Workflow Engine will only CREATE this request. Default
     * value is false.
     * <p>
     * @return This API will return a JSON object which will have some
     * information of the request:
     * <br>
     * - Basic information like: id, title, current state, created user, updated
     * user, created time, udpated time
     * <br>
     * - Available actions: the actions users can perform right now(e.g:
     * APPROVE, REJECT, CANCEL, …)
     * <br>
     * - Need-to-be-done activities: after users apply/approve/reject a
     * request(perform an action), there will be something need to be done.
     * (e.g: send mail to stakeholders)
     */
    Request makeRequest(long processId, long userId, String title, boolean doApply);

}
