import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RegisterLoginCommand} from "../models/registerlogincommand.model";
import {RegisterLoginComponent} from "../app/components/register-login/register-login.component";
import {environment} from "../environments/environment";
import {TokenResponse} from "../models/tokenresponse.model";
import {IdeaCommand} from "../models/ideacommand.model";
import {IdeaListItem} from "../models/idealistitem.model";
import {AcceptRejectIdeaCommand} from "../models/acceptrejectcommand";
import {VoteCommand} from "../models/votecommand.model";
import {SessionVotes} from "../models/sessionvotes";

const baseUrl = environment.BASE_URL;

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  register(data: RegisterLoginCommand) {
    return this.http.post(baseUrl + "/api/auth/register", data)
  }

  login(data: RegisterLoginComponent) {
    return this.http.post<TokenResponse>(baseUrl + "/api/auth/login", data)
  }

  submitIdea(data: IdeaCommand) {
    return this.http.post(baseUrl + "/api/ideas/create-idea", data)
  }

  listIdeaUser(data: SessionVotes) {
    return this.http.post<Array<IdeaListItem>>(baseUrl + "/api/ideas/list-enabled", data)
  }

  listIdeaAdmin() {
    return this.http.get<Array<IdeaListItem>>(baseUrl + "/api/ideas/list-disabled")
  }

  decideIdeaStatus(data: AcceptRejectIdeaCommand) {
    return this.http.put(baseUrl + "/api/ideas/decide-idea-status", data)
  }

  castVote(data: VoteCommand) {
    return this.http.post(baseUrl + "/api/votes/vote", data)
  }

  getSessionVotes() {
    const votedIdeasString = localStorage.getItem('session-votes')
    if(votedIdeasString != null) {
      const votedIdeas = JSON.parse(votedIdeasString);
      const data: SessionVotes = {ideaIds: votedIdeas}
      return data
    } else {
      const data: SessionVotes = {ideaIds: []}
      return data
    }


  }

}
