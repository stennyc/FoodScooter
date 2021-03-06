import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RestaurantsViewerComponent } from './viewer/restaurants-viewer.component';
import { MaterialModule } from '../../core/material.module';
import { RouterModule } from '@angular/router';
import { RestaurantViewerComponent } from './restaurant/viewer/restaurant-viewer.component';
import { RestaurantReviewsViewerComponent } from './restaurant/reviews-viewer/restaurant-reviews-viewer.component';
import { RestaurantOrderPlacerComponent } from './restaurant/order-placer/restaurant-order-placer.component';
import { RestaurantMenuViewerComponent } from './restaurant/menu-viewer/restaurant-menu-viewer.component';
import { ReactiveFormsModule } from '@angular/forms';
import { PipesModule } from '../../pipes/pipes.module';

@NgModule({
  declarations: [
    RestaurantsViewerComponent,
    RestaurantViewerComponent,
    RestaurantReviewsViewerComponent,
    RestaurantOrderPlacerComponent,
    RestaurantMenuViewerComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    RouterModule,
    PipesModule,
    ReactiveFormsModule
  ],
  exports: [
    RestaurantsViewerComponent,
    RestaurantViewerComponent
  ]
})
export class RestaurantsModule { }
