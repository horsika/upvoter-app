import { Component, OnInit } from '@angular/core';
import {IdeaListItem} from "../../../models/idealistitem.model";
import {AcceptRejectIdeaCommand} from "../../../models/acceptrejectcommand";
import {UserService} from "../../../services/user.service";
import {SessionVotes} from "../../../models/sessionvotes";

@Component({
  selector: 'app-admin-dash',
  templateUrl: './admin-dash.component.html',
  styleUrls: ['./admin-dash.component.css']
})
export class AdminDashComponent implements OnInit {

  ideaList: IdeaListItem[] = [];
  newIdeaList: IdeaListItem[] = [];
  menuChoice: string | undefined;
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

  chooseIdeas() {
    this.menuChoice = 'VotingList'
    const data = this.userService.getSessionVotes()
    this.userService.listIdeaUser(data).subscribe({
      next: value => this.ideaList = value
    })
  }

  chooseNewIdeas() {
    this.menuChoice = 'NewIdeas'
    this.userService.listIdeaAdmin().subscribe({
      next: value => this.newIdeaList = value
    })
  }

  accept(ideaId: number) {
    const data: AcceptRejectIdeaCommand = {ideaId: ideaId, decision: 'ACCEPTED'}
    this.userService.decideIdeaStatus(data).subscribe({
      complete: () => this.chooseNewIdeas()
    })
  }

  reject(ideaId: number) {
    const data: AcceptRejectIdeaCommand = {ideaId: ideaId, decision: 'REJECTED'}
    this.userService.decideIdeaStatus(data).subscribe({
      complete: () => this.chooseNewIdeas()
    })
  }


}
