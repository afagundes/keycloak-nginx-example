import {Component, OnInit} from '@angular/core';
import {MessageService} from "../../service/message.service";
import {AuthService} from "../../service/auth.service";

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  public message = 'Loading...';

  constructor(private messageService: MessageService, private authService: AuthService) {}

  ngOnInit(): void {
    this.getNextMessage();
  }

  getNextMessage() {
    this.messageService.getMessage().subscribe(response => this.message = response.message);
  }

  async logout() {
    await this.authService.logout();
  }

}
