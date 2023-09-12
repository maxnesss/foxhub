import { Component, HostListener } from '@angular/core';

@Component({
  selector: 'app-swiper-arrow',
  templateUrl: './swiper-arrow.component.html',
  styleUrls: ['./swiper-arrow.component.css']
})
export class SwiperArrowComponent {

  @HostListener('click')
  onClick() {
    const windowHeight = window.innerHeight;
    const currentPosition = window.scrollY;
    const targetPosition = currentPosition + windowHeight;

    const maxScrollPosition = Math.max(
      document.body.scrollHeight,
      document.body.offsetHeight,
      document.documentElement.clientHeight,
      document.documentElement.scrollHeight,
      document.documentElement.offsetHeight
    ) - windowHeight;

    const finalPosition = Math.min(targetPosition, maxScrollPosition);

    function smoothScroll() {
      const distance = finalPosition - window.scrollY;
      const step = Math.ceil(distance / 20);

      if (Math.abs(distance) <= Math.abs(step)) {
        window.scroll(0, finalPosition);
      } else {
        window.scrollBy(0, step);
        window.requestAnimationFrame(smoothScroll);
      }
    }

    smoothScroll();
  }
}
