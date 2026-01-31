import { Component } from '@angular/core';
import { UserService } from '../../../services/user.service/user.service';
import { ChangeDetectorRef } from '@angular/core';
// import { CommonModule, JsonPipe } from '@angular/common';
@Component({
  selector: 'app-user.component',
  imports: [],
  templateUrl: './user.component.html',
  styleUrl: './user.component.css',
})
export class UserComponent {
  users:any[] = [];

  constructor(private userServi: UserService,private chp: ChangeDetectorRef) {
    this.userServi.getUsers().subscribe(data => {
      this.users = data;
      console.log(data);
      this.chp.detectChanges();
    });
  }
}
