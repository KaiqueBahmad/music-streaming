import { NgFor } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-playlists',
  standalone: true,
  imports: [NgFor],
  template: `
  <div>
  <h2>Playlists</h2>
  <ul class="music-box" *ngFor="let playlist of playlists">
      <li>
        <img src="{{playlist[0]}}" alt="{{playlist[1]}}">
        <span>{{playlist[1]}}</span>
      </li>
    </ul>
  </div>
`,
  styleUrl: './playlists.component.css'
})
export class PlaylistsComponent {
  playlists = [
    ["https://cdn-icons-png.flaticon.com/512/5016/5016381.png", "Workout"],
    ["https://img.freepik.com/vetores-gratis/ilustracao-de-gradiente-lo-fi_23-2149375749.jpg?size=338&ext=jpg&ga=GA1.1.1546980028.1714176000&semt=sph", "Lo-Fi"]
  ]
}
