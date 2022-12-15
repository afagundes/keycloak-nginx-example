import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Message} from "../interface/message";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private httpClient: HttpClient) {}

  public getMessage(): Observable<Message> {
    return this.httpClient.get<Message>(`${environment.api}/message`);
  }

}
