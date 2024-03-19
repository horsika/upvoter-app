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
  menuChoice: string = '';
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
    this.menuChoice = "VotingList"
  }

  chooseList() {
    this.menuChoice = "VotingList"
    this.userService.listIdeaUser().subscribe({
      next: value => this.ideaList = value
    })
  }

  chooseIdea() {
    this.menuChoice = "IdeaForm"
  }

  submitIdea() {
    const data = this.idea.value
    this.userService.submitIdea(data).subscribe({
        complete: () => this.router.navigate(["/user-dash"])
      }
    )
  }

  castUpVote(ideaId: number) {
    const data: VoteCommand = {vote: true, ideaId: ideaId}
    this.userService.castVote(data).subscribe({})
  }

  castDownVote(ideaId: number) {
    const data: VoteCommand = {vote: false, ideaId: ideaId}
    this.userService.castVote(data).subscribe({})
  }


}
