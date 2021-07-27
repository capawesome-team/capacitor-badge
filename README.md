<p align="center"><br><img src="https://user-images.githubusercontent.com/236501/85893648-1c92e880-b7a8-11ea-926d-95355b8175c7.png" width="128" height="128" /></p>
<h3 align="center">Badge</h3>
<p align="center"><strong><code>@robingenz/capacitor-badge</code></strong></p>
<p align="center">
  Capacitor plugin to access and update the badge number of the app icon.
</p>

<p align="center">
  <img src="https://img.shields.io/maintenance/yes/2021?style=flat-square" />
  <a href="https://github.com/robingenz/capacitor-badge/actions?query=workflow%3A%22CI%22"><img src="https://img.shields.io/github/workflow/status/robingenz/capacitor-badge/CI/main?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@robingenz/capacitor-badge"><img src="https://img.shields.io/npm/l/@robingenz/capacitor-badge?style=flat-square" /></a>
<br>
  <a href="https://www.npmjs.com/package/@robingenz/capacitor-badge"><img src="https://img.shields.io/npm/dw/@robingenz/capacitor-badge?style=flat-square" /></a>
  <a href="https://www.npmjs.com/package/@robingenz/capacitor-badge"><img src="https://img.shields.io/npm/v/@robingenz/capacitor-badge?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:START - Do not remove or modify this section -->
<a href="#contributors-"><img src="https://img.shields.io/badge/all%20contributors-1-orange?style=flat-square" /></a>
<!-- ALL-CONTRIBUTORS-BADGE:END -->
</p>

## Maintainers

| Maintainer | GitHub                                    | Social                                        |
| ---------- | ----------------------------------------- | --------------------------------------------- |
| Robin Genz | [robingenz](https://github.com/robingenz) | [@robin_genz](https://twitter.com/robin_genz) |

## Installation

```bash
npm install @robingenz/capacitor-badge
npx cap sync
```

### Android Variables

This plugin will use the following project variables (defined in your app’s `variables.gradle` file):
- `$shortcutBadgerVersion` version of `me.leolin:ShortcutBadger` (default: `1.1.22`)

## Configuration

No configuration required for this plugin.

## Demo

A working example can be found here: [robingenz/capacitor-plugin-demo](https://github.com/robingenz/capacitor-plugin-demo)

## Usage

```typescript
import { Badge } from '@robingenz/capacitor-badge';

const get = async () => {
  const result = await Badge.get();
};

const set = async (count: number) => {
  await Badge.set({ count });
};

const clear = async () => {
  await Badge.clear();
};

const checkPermissions = async () => {
  const result = await Badge.checkPermissions();
};

const requestPermissions = async () => {
  const result = await Badge.requestPermissions();
};
```

## API

<docgen-index>

* [`get()`](#get)
* [`set(...)`](#set)
* [`increase()`](#increase)
* [`decrease()`](#decrease)
* [`clear()`](#clear)
* [`isSupported()`](#issupported)
* [`checkPermissions()`](#checkpermissions)
* [`requestPermissions()`](#requestpermissions)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### get()

```typescript
get() => Promise<GetBadgeResult>
```

Get the badge count.
The badge count won't be lost after a reboot or app restart.

Default: `0`.

**Returns:** <code>Promise&lt;<a href="#getbadgeresult">GetBadgeResult</a>&gt;</code>

--------------------


### set(...)

```typescript
set(options: SetBadgeOptions) => Promise<void>
```

Set the badge count.

| Param         | Type                                                        |
| ------------- | ----------------------------------------------------------- |
| **`options`** | <code><a href="#setbadgeoptions">SetBadgeOptions</a></code> |

--------------------


### increase()

```typescript
increase() => Promise<void>
```

Increase the badge count.

--------------------


### decrease()

```typescript
decrease() => Promise<void>
```

Decrease the badge count.

--------------------


### clear()

```typescript
clear() => Promise<void>
```

Clear the badge count.

--------------------


### isSupported()

```typescript
isSupported() => Promise<IsSupportedResult>
```

Check if the badge count is supported.

**Returns:** <code>Promise&lt;<a href="#issupportedresult">IsSupportedResult</a>&gt;</code>

--------------------


### checkPermissions()

```typescript
checkPermissions() => Promise<PermissionStatus>
```

Check permission to display badge.

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### requestPermissions()

```typescript
requestPermissions() => Promise<PermissionStatus>
```

Request permission to display badge.

**Returns:** <code>Promise&lt;<a href="#permissionstatus">PermissionStatus</a>&gt;</code>

--------------------


### Interfaces


#### GetBadgeResult

| Prop        | Type                |
| ----------- | ------------------- |
| **`count`** | <code>number</code> |


#### SetBadgeOptions

| Prop        | Type                |
| ----------- | ------------------- |
| **`count`** | <code>number</code> |


#### IsSupportedResult

| Prop              | Type                 |
| ----------------- | -------------------- |
| **`isSupported`** | <code>boolean</code> |


#### PermissionStatus

| Prop          | Type                                                        | Description                               |
| ------------- | ----------------------------------------------------------- | ----------------------------------------- |
| **`display`** | <code><a href="#permissionstate">PermissionState</a></code> | Permission state of displaying the badge. |


### Type Aliases


#### PermissionState

<code>'prompt' | 'prompt-with-rationale' | 'granted' | 'denied'</code>

</docgen-api>

## Quirks

On **Android** not all launchers support badges. This plugin uses [ShortcutBadger](https://github.com/leolin310148/ShortcutBadger). All supported launchers are listed [there](https://github.com/leolin310148/ShortcutBadger#supported-launchers).

## Changelog

See [CHANGELOG.md](https://github.com/robingenz/capacitor-badge/blob/master/CHANGELOG.md).

## License

See [LICENSE](https://github.com/robingenz/capacitor-badge/blob/master/LICENSE).
