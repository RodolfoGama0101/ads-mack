import type { SVGProps } from "react";

type IconProps = SVGProps<SVGSVGElement>;

export function ArrowIcon(props: IconProps) {
  return <svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true" {...props}><path d="M5 12h14M13 6l6 6-6 6" stroke="currentColor" strokeWidth="1.6" strokeLinecap="square" strokeLinejoin="miter" /></svg>;
}

export function ArrowUpRightIcon(props: IconProps) {
  return <svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true" {...props}><path d="M6 18 18 6M6 6h12v12" stroke="currentColor" strokeWidth="1.6" /></svg>;
}

export function BoxIcon(props: IconProps) {
  return <svg width="24" height="24" viewBox="0 0 24 24" fill="none" aria-hidden="true" {...props}><path d="m12 3 9 5v8l-9 5-9-5V8l9-5Zm0 10v8M3 8l9 5 9-5M7.5 5.5l9 5V15" stroke="currentColor" strokeWidth="1.4" strokeLinejoin="round" /></svg>;
}

export function CheckIcon(props: IconProps) {
  return <svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true" {...props}><path d="m5 12 4 4L19 6" stroke="currentColor" strokeWidth="1.7" /></svg>;
}

export function PlusIcon(props: IconProps) {
  return <svg width="20" height="20" viewBox="0 0 24 24" fill="none" aria-hidden="true" {...props}><path d="M5 12h14M12 5v14" stroke="currentColor" strokeWidth="1.5" /></svg>;
}

export function BrandMark(props: IconProps) {
  return <svg width="38" height="38" viewBox="0 0 40 40" fill="none" aria-hidden="true" {...props}><path d="M2 20 20 2h18L20 20H2Zm0 18 18-18h18L20 38H2Z" fill="currentColor" /></svg>;
}
