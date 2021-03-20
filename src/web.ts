import { WebPlugin } from '@capacitor/core';

import type { BadgePlugin } from './definitions';

export class BadgeWeb extends WebPlugin implements BadgePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
