import { Component } from '@angular/core';
import { FeaturedComponent } from './featured/featured.component';
import { PlaylistsComponent } from './playlists/playlists.component';

@Component({
  selector: 'app-content',
  standalone: true,
  imports: [FeaturedComponent, PlaylistsComponent],
  template: `
  <div id="content">
    <app-featured></app-featured>
    <app-playlists></app-playlists>
  </div>
  `,
  styleUrl: './content.component.css'
})
export class ContentComponent {

}
