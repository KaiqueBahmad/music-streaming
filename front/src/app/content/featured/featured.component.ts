import { NgFor } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-featured',
  standalone: true,
  imports: [NgFor],
  template: `
  <div>
    <h2>Featured Songs</h2>
    <ul class="music-box" *ngFor="let music of musics">
      <li>
        <img src="{{music[0]}}" alt="{{music[1]}}">
        <span>{{music[1]}}</span>
      </li>
    </ul>
  </div>
  `,
  styleUrl: './featured.component.css'
})
export class FeaturedComponent {
  musics = [
    ["https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0TrTPiI9xrHnGGHveAPPyomkZZowYoLQxms5f5JJaLw&s=10","Yesterday - Beatles"],
    ["https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR20X9qzfI3_LwEaouY6ztV5XiWRudIHZa-qRypgzh5yBdguCrVi-omFwpULQ&s=10", "505 - Arctic Monkeys"]
  ]
  //TO-DO the Featured songs should also be provided by a service
}
