import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  constructor() {}

  miNgClass = false;
  ngOnInit(): void {
    setTimeout(() => {
      this.miNgClass = true;
    }, 1500);
  }
}
