import { Directive, ElementRef, OnInit } from '@angular/core';

@Directive({
  selector: '[appRevealWithDelay]'
})
export class RevealWithDelayDirective implements OnInit {
  constructor(private elementRef: ElementRef<HTMLElement>) {}

  ngOnInit() {
    setTimeout(() => {
      const element = this.elementRef.nativeElement;
      if (!element.classList.contains('reveal')) {
        if (this.isElementInViewport(element)) {
          element.classList.add('reveal');
        }
      }
    }, 200); // 1 sec is 1000 (milliseconds)
  }

  private isElementInViewport(element: HTMLElement): boolean {
    const rect = element.getBoundingClientRect();
    return rect.top >= 0 && rect.bottom <= window.innerHeight;
  }
}
