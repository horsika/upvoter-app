import {Component, OnInit} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";
import {IdeaListItem} from "../../../models/idealistitem.model";
import {VoteCommand} from "../../../models/votecommand.model";

@Component({
  selector: 'app-user-dash',
  templateUrl: './user-dash.component.html',
  styleUrls: ['./user-dash.component.css']
})
export class UserDashComponent implements OnInit {

  idea: FormGroup;
  menuChoice: string | undefined;
  ideaList: IdeaListItem[] = [];

  constructor(private userService: UserService,
              private router: Router,
              private formBuilder: FormBuilder) {
    this.idea = this.formBuilder.group({
      'title': [''],
      'description': ['']
    })
  }

  ngOnInit(): void {
    this.menuChoice = 'VotingList'
  }

  chooseList() {
    this.menuChoice = 'VotingList'
    const data = this.userService.getSessionVotes()
    this.userService.listIdeaUser(data).subscribe({
      next: value => this.ideaList = value
    })
  }

  chooseIdea() {
    this.menuChoice = 'IdeaForm'
  }

  submitIdea() {
    const data = this.idea.value
    this.userService.submitIdea(data).subscribe({
        complete: () => this.chooseList()
      }
    )
  }

  castUpVote(ideaId: number) {
    this.storeSessionVotes(ideaId)
    const data: VoteCommand = {vote: true, ideaId: ideaId}
    this.userService.castVote(data).subscribe({
      complete: () => this.chooseList()
    })
  }

  castDownVote(ideaId: number) {
    this.storeSessionVotes(ideaId)
    const data: VoteCommand = {vote: false, ideaId: ideaId}
    this.userService.castVote(data).subscribe({
      complete: () => this.chooseList()
    })
  }

  storeSessionVotes(ideaId: number) {
    const sessionVotes = localStorage.getItem('session-votes')
    if(sessionVotes == null) {
      const idArray = [ideaId];
      localStorage.setItem('session-votes', JSON.stringify(idArray))
    } else {
      const idArray = JSON.parse(sessionVotes);
      idArray.push(ideaId)
      localStorage.setItem('session-votes', JSON.stringify(idArray))
    }
  }



}
